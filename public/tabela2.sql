SELECT ime_prezime,
		 naziv,
		 cena
FROM   paket,
		 trener,
		 trener_paket
WHERE paket.paket_id = trener_paket.paket_id AND
		trener.trener_id = trener_paket.trener_id