(ns logica-computacional-ep3.functions (:require [clojure.data.json :as json]
                                                 [clojure.string :as str]
                                                 [clojure.java.io :as io]))


(defn final-state [automaton string]
  (let [split-chain (str/split string #"")]
    (reduce (fn [state symbol]
              (((automaton "transition") symbol) state))
            (automaton "start")
            split-chain)))

(defn accepts-dfa? [automaton chain]
  (contains? (set (automaton "accept")) (final-state automaton chain)))

(defn read-automaton-definition
  [fname]
  (let [json-data (slurp (io/resource fname))
        automaton-definition (json/read-str json-data)]
    automaton-definition))

(defn accepts-nfa? [automaton state input]
  (if (empty? input)
    (contains? (set (automaton "accept")) state)
    (let [transition (automaton "transition")
          states-from (transition (first input))

          possible-transitions (if (contains? states-from state)
                                 (states-from state)
                                 ["reject"])

          input-symbol-consumed (drop 1 input)

          next-params-from-transitions (map (fn [possible-transition] [automaton possible-transition input-symbol-consumed]) possible-transitions)

          next-params (if (and (contains? transition "") (contains? (transition "") state))
                        (reduce (fn [result epslon-state] (conj result [automaton epslon-state input])) next-params-from-transitions ((transition "") state))
                        next-params-from-transitions)]
      (reduce
       (fn [result params] (or result (apply accepts-nfa? params)))
       false
       next-params))))