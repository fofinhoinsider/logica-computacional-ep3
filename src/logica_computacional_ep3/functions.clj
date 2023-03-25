(ns logica-computacional-ep3.functions (:require [clojure.data.json :as json]
                                                 [clojure.string :as str]))


(defn final-state [automaton string]
  (let [list (str/split string #"")]
    (reduce (fn [state input]
              (((automaton "transition") input) state))
            (automaton "start")
            list)))

(defn read-automaton-definition
  [fname]
  (let [json-data (slurp fname)
        automaton-definition (json/read-str json-data)]
    automaton-definition))

(defn sei-la [automaton state input]
  (let [transition (automaton "transition")
        states-from (transition (first input))

        possible-transitions (if (contains? states-from state)
                               (states-from state)
                               ["reject"])
        next-params (if (and (contains? transition "") (contains? (transition "") state))
                      (into [] (concat possible-transitions ((transition "") state)))
                      possible-transitions)
        _ (println "next params: " next-params)

        next-input (drop 1 input)]
    (println "a: " state " - " input)
    (println "b: " possible-transitions " - " next-input)
    (if (empty? input)
      (contains? (set (automaton "accept")) state)
      (reduce
       (fn [result next-state] (or result (sei-la automaton next-state next-input)))
       false
       possible-transitions))))

(defn final-state-nfa
  [automaton string]
  (let [list (str/split string #"")]
    (sei-la automaton (automaton "start") list)))

(def automaton {"start" "q0", "accept" ["q2"], "transition" {"a" {"q0" ["q3" "q1"], "q1" ["q2"]}}})

(def alphabet (keys (automaton "transition")))

(reduce (fn [result key] (assoc-in result ["transition" key "final"] [])) automaton alphabet)