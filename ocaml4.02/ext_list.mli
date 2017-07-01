open Core.Std

(* This module extends the List module, adding the function intersperse to it.
   If one wants to use this new function, one way of doing it is through

   module List = Ext_list

   The intersperse function will be available along with all other List
   functions.  *)

include (module type of List)

val my_intersperse : 'a list -> 'a -> 'a list
