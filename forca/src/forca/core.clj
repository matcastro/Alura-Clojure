(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

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

(defn avalia-chute [chute vidas palavra acertos]
	(if(acertou? chute palavra)
		(jogo vidas palavra (conj acertos chute))
		(jogo (dec vidas) palavra acertos)
	)
)

(defn jogo [vidas palavra acertos] 
	(if (= vidas 0)
		(perdeu)
		(if (acertou-toda-a-palavra? palavra acertos) 
			(ganhou) 
			(avalia-chute (le-letra!) vidas palavra acertos)
		)
	)
)

(defn letra-inteira [funcao]
	(* (Integer/parseInt (funcao)) 7)
)

(defn fib [n] 
	(if (= n 0) 0
		(if (= n 1) 1
		 (+ (fib (dec n)) (fib (- n 2))))))

(defn filtro [nums]
	(filter 
		(fn [x] (or (> x 4) (< x 2))
		) nums
	)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
