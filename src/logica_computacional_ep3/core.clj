(ns logica-computacional-ep3.core
  (:gen-class)
  (:require [logica-computacional-ep3.example-automatons :refer [automatonI]]
            [logica-computacional-ep3.functions :refer [final-state]]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "O estado final ao se aplicar o autômato à cadeia é: " (final-state automatonI (list 1 0 1 1 0 1 0 1 1))))




;; The final state after all the input is consumed is :B, which is an accepting state




; (final-state automatonI (list 1 0 1 1 0 1 0 1 1)) ;-> :B
; (final-state automatonI (list 1 0 1 1 0 1 0 1 0)) ;-> :A

;; And so the string 101101011 is accepted by the automaton.

(defn accepts [automaton string]
  (not (nil? ((automaton :accept)
              (final-state automaton string)))))

; (accepts automatonI (list 1 0 1 1 0 1 0 1 1)) ;-> true
; (accepts automatonI (list 1 0 1 1 0 1 0 1 0)) ;-> false


