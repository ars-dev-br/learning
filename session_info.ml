open Core.Std

(* Modules may be defined inside other modules with module <Name> : <signature>
   = <implementation>, like this: *)

module Domain : sig
  type t
  val of_string : string -> t
  val to_string : t -> string
end = struct
  type t = string
  let of_string x = x
  let to_string x = x
end

(* It's also possible to create new modules first defining a signature, and then
   defining its implementation.  *)

module type Id = sig
  type t
  val of_string : string -> t
  val to_string : t -> string
end

module String_id = struct
  type t = string
  let of_string x = x
  let to_string x = x
end

module Username : Id = String_id
module Hostname : Id = String_id

type session_info = { user: Username.t;
                      domain: Domain.t;
                      host: Hostname.t;
                      when_started: Time.t;
                    }

let sessions_have_same_user s1 s2 =
  s1.user = s2.user
