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

(defn jogo [vidas palavra acertos] 
	(if (= vidas 0)
		(perdeu)
		(if (acertou-toda-a-palavra? palavra acertos) 
			(ganhou) 
			(print "Chuta a próxima letra.")
		)
	)
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
