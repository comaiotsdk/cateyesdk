package com.bumptech.comaiot_glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.comaiot_glide.load.Options;
import com.bumptech.comaiot_glide.load.ResourceDecoder;
import com.bumptech.comaiot_glide.load.engine.Resource;
import com.bumptech.comaiot_glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * Decodes {@link Bitmap Bitmaps} from {@link ByteBuffer ByteBuffers}.
 */
public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {
  private final Downsampler downsampler;

  public ByteBufferBitmapDecoder(Downsampler downsampler) {
    this.downsampler = downsampler;
  }

  @Override
  public boolean handles(@NonNull ByteBuffer source, @NonNull Options options) {
    return downsampler.handles(source);
  }

  @Override
  public Resource<Bitmap> decode(@NonNull ByteBuffer source, int width, int height,
      @NonNull Options options)
      throws IOException {
    InputStream is = ByteBufferUtil.toStream(source);
    return downsampler.decode(is, width, height, options);
  }
}
