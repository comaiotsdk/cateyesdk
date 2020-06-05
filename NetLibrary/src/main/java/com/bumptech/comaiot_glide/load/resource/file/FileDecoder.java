package com.bumptech.comaiot_glide.load.resource.file;

import android.support.annotation.NonNull;
import com.bumptech.comaiot_glide.load.Options;
import com.bumptech.comaiot_glide.load.ResourceDecoder;
import com.bumptech.comaiot_glide.load.engine.Resource;
import java.io.File;

/**
 * A simple {@link com.bumptech.comaiot_glide.load.ResourceDecoder} that creates resource for a given {@link
 * File}.
 */
public class FileDecoder implements ResourceDecoder<File, File> {

  @Override
  public boolean handles(@NonNull File source, @NonNull Options options) {
    return true;
  }

  @Override
  public Resource<File> decode(@NonNull File source, int width, int height,
      @NonNull Options options) {
    return new FileResource(source);
  }
}
