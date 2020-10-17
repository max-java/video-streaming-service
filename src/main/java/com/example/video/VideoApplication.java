package com.example.video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.content.commons.repository.Store;
import org.springframework.content.fs.config.EnableFilesystemStores;
import org.springframework.content.fs.io.FileSystemResourceLoader;
import org.springframework.content.rest.StoreRestResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@SpringBootApplication
public class VideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
	}

	@Configuration
	@EnableFilesystemStores
	public static class StoreConfig {
		File filesystemRoot() {
			// return the root of your video store
			return new File("/home/max/web/files/jis4");
		}

		// this bean is the spring resource loader that will be used by
		// the product store
		@Bean
		public FileSystemResourceLoader fsResourceLoader() throws Exception
		{
			return new FileSystemResourceLoader(filesystemRoot().getAbsolutePath());
		}
	}

	@StoreRestResource(path="videosrc")
	public interface VideoStore extends Store<String> {
		//
	}
}
