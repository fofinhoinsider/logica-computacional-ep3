(ns logica-computacional-ep3.core
  (:gen-class)
  (:require [logica-computacional-ep3.functions :refer [read-automaton-definition accepts-dfa? accepts-nfa?]]
            [clojure.string :as str]))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println args)
  (let [determinism (nth args 0)
        file-name (nth args 1)
        chain (nth args 2)
        automaton (read-automaton-definition file-name)]
    (if (= determinism "dfa")
      (println (accepts-dfa? automaton chain))
      (println (accepts-nfa? automaton (automaton "start") (str/split chain #""))))))