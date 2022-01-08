package com.projecthope.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsContentApplication {

	/**
	 * 	MinIO kullanırken sizlere tavsiyem dosya yüklemelerinizi dosya yolundan değilde
	 * 	MemoryStream ‘ler kullanarak dosyaları yüklemeniz olacaktır.
	 * 	Projemizde yaptığımız sistem denemelerinde MinIO üzerinde bu yolla yükleme yapmak çok daha
	 * 	hızlı sonuç vermektedir.
	 */

	public static void main(String[] args) {
		SpringApplication.run(MsContentApplication.class, args);
	}

}
