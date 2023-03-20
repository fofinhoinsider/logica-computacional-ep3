(ns logica-computacional-ep3.functions)


(defn final-state [automaton string]
  (reduce (fn [state input]
            (((automaton :transition) input) state))
          (automaton :start)
          string))