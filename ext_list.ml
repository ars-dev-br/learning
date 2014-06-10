open Core.Std

let rec my_intersperse list el =
  match list with
  | [] | [ _ ] -> list
  | x :: y :: tl -> x :: el :: my_intersperse (y::tl) el

include List
