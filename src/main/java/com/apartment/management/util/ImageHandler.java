package com.apartment.management.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageHandler
{

	public static boolean saveImage(MultipartFile image, String path,
			ServletContext servletContext) throws IOException
	{
		if ( !image.isEmpty() )
		{
			File file = new File(servletContext.getRealPath("/") + "/" + path);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			return true;
		}
		return false;
	}

	public static boolean deleteImage(String path, ServletContext servletContext)
			throws IOException
	{
		File file = new File(servletContext.getRealPath("/") + "/" + path);
		if ( file.isFile() )
		{
			FileUtils.forceDelete(file);
			return true;
		}
		return false;
	}
}
