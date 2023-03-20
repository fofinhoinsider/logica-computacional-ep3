(ns logica-computacional-ep3.example-automatons)

(def automatonI {:start :A
                 :accept #{:B}
                 :transition {1 {:A :B :B :B}
                              0 {:A :A :B :A}}})

(def automatonII {:start :A
                  :accept #{:B}
                  :transition {1 {:A :B :B :A}
                               0 {:A :A :B :B}}})

(def automatonIII {:start :A
                   :accept #{:A}
                   :transition {1 {:A :B :B :A :C :C}
                                0 {:A :A :B :C :C :B}}})