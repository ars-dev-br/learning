open Core.Std

module type Comparable = sig
  type t
  val compare : t -> t -> int
end ;;

module Make_interval(Endpoint : Comparable) = struct
  type t =
    | Interval of Endpoint.t * Endpoint.t
    | Empty

  (** [create low high] creates a new interval from [low] to [high].  If
      [low > high], then the interval is empty. *)
  let create low high =
    if Endpoint.compare low high > 0 then Empty
    else Interval (low, high)

  (** Return true iff the interval is empty. *)
  let is_empty = function
    | Empty -> true
    | Interval _ -> false

  (** [contains t x] returns true iff [x] is contained in the interval [t]. *)
  let contains t x =
    match t with
    | Empty -> false
    | Interval (l,h) ->
       Endpoint.compare x l >= 0 && Endpoint.compare x h <= 0

  (** [intersect t1 t2] returns the intersection of the two input intervals. *)
  let intersect t1 t2 =
    let min x y = if Endpoint.compare x y <= 0 then x else y in
    let max x y = if Endpoint.compare x y >= 0 then x else y in
    match t1,t2 with
    | Empty, _ | _, Empty -> Empty
    | Interval (l1,h1), Interval (l2,h2) ->
       create (max l1 l2) (min h1 h2)

end ;;

(* We can make intervals based on any module that has a type t and implements
   a function compare with the same signature as [Endpoint.compare].  This
   happens to be true for the [Int] and [String] modules.

   This is on purpose, and there is no need to declare that [Int] and [String]
   implement the Endpoint signature, as OCaml can infer it. *)
module Int_interval = Make_interval(Int)

let () =
  let i1 = Int_interval.create 3 8 in
  let i2 = Int_interval.create 4 10 in
  match Int_interval.intersect i1 i2 with
  | Int_interval.Interval (l,h) -> printf "%d-%d\n" l h
  | Empty -> printf "empty\n"
