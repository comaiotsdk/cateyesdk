package com.bumptech.comaiot_glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.bumptech.comaiot_glide.request.Request;

/**
 * A base {@link Target} for loading {@link com.bumptech.comaiot_glide.load.engine.Resource}s that provides
 * basic or empty implementations for most methods.
 *
 * <p>For maximum efficiency, clear this target when you have finished using or displaying the
 * {@link com.bumptech.comaiot_glide.load.engine.Resource} loaded into it using {@link
 * com.bumptech.comaiot_glide.RequestManager#clear(Target)}.
 *
 * <p>For loading {@link com.bumptech.comaiot_glide.load.engine.Resource}s into {@link android.view.View}s,
 * {@link com.bumptech.comaiot_glide.request.target.ViewTarget} or {@link
 * com.bumptech.comaiot_glide.request.target.ImageViewTarget} are preferable.
 *
 * @param <Z> The type of resource that will be received by this target.
 * @deprecated Use {@link CustomViewTarget} if loading the content into a view, the download API if
 *     in the background
 *     (http://bumptech.github.io/glide/doc/getting-started.html#background-threads), or a a fully
 *     implemented {@link Target} for any specialized use-cases. Using BaseView is unsafe if the
 *     user does not implement {@link #onLoadCleared}, resulting in recycled bitmaps being
 *     referenced from the UI and hard to root-cause crashes.
 */
@Deprecated
public abstract class BaseTarget<Z> implements Target<Z> {

  private Request request;

  @Override
  public void setRequest(@Nullable Request request) {
    this.request = request;
  }

  @Override
  @Nullable
  public Request getRequest() {
    return request;
  }

  @Override
  public void onLoadCleared(@Nullable Drawable placeholder) {
    // Do nothing.
  }

  @Override
  public void onLoadStarted(@Nullable Drawable placeholder) {
    // Do nothing.
  }

  @Override
  public void onLoadFailed(@Nullable Drawable errorDrawable) {
    // Do nothing.
  }

  @Override
  public void onStart() {
    // Do nothing.
  }

  @Override
  public void onStop() {
    // Do nothing.
  }

  @Override
  public void onDestroy() {
    // Do nothing.
  }
}
