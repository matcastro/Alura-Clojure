(ns forca.core
  (:gen-class))

(def total-de-vidas 6)
(def palavra-secreta "CARRO")

(defn perdeu [] (print "Voce perdeu!"))
(defn ganhou [] (print "Voce ganhou!"))

(defn letras-faltantes [palavra acertos]
	(remove (fn [letra] (contains? acertos (str letra))) palavra)
)

(defn acertou-toda-a-palavra? [palavra acertos] 
	(empty? (letras-faltantes palavra acertos))
)

(defn le-letra! [] (read-line))

(defn acertou? [chute palavra]
	(.contains palavra chute)
)

(defn imprime-forca [vidas palavra acertos]
	(println  "Vidas " vidas)
	(doseq [letra (seq palavra)]
		(if(contains? acertos (str letra))
			(print letra " ") (print "_" " ")
		) 
	)
	(println)
)

(defn jogo [vidas palavra acertos] 
	(imprime-forca vidas palavra acertos)
	(if (= vidas 0)
		(perdeu)
		(if (acertou-toda-a-palavra? palavra acertos) 
			(ganhou)
			(let [chute (le-letra!)]
				(if(acertou? chute palavra)
					(do
						(println "Acertou a letra!")
						(recur vidas palavra (conj acertos chute))
					)
					(do
						(println "Errou a letra...")
						(recur (dec vidas) palavra acertos)
					)
				)
			)
		)
	)
)

(defn comeca-o-jogo [] (jogo total-de-vidas palavra-secreta #{}))

(defn letra-inteira [funcao]
	(* (Integer/parseInt (funcao)) 7)
)

(defn fib [n] 
	(loop [a 1 b 1 numero 2]
	(if (= numero n) b
		(recur b (+ a b) (inc numero))
	)
	)
)
	
(defn filtro [nums]
	(filter 
		(fn [x] (or (> x 4) (< x 2))
		) nums
	)
)

(defn soma [n]
	(loop [contador 1 soma 0]
		(if (> contador n) soma
			(recur (inc contador) (+ contador soma))
		)
	)
)

(defn -main [& args]
  (comeca-o-jogo)
)
