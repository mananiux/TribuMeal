package com.tribumeal.utilities.network;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;


/**
 * Created by manano on 1/16/17.
 */


public class ImageRestClient extends  AsyncTask<String, Void, Bitmap>
        {

        private URL url;
        ImageView bmImage;
        public ImageRestClient(ImageView bmImage) {
            this.bmImage = bmImage;
        }


        /**
         * Background task to call Drive API.
         * @param params no parameters needed for this task.
         */
        @Override
        protected Bitmap doInBackground(String... params) {

            Bitmap resultImage = null;
            try {
                String path = params[0];
                url  = new URL("http://placeholdit.imgix.net/~text?"+path);

                InputStream in = url.openStream();
                resultImage = BitmapFactory.decodeStream(in);

                System.out.println("Found image");
                return resultImage;
            } catch (Exception e) {
                System.out.println("Error retrieving image" + e.getMessage());
                return null;
            }
        }



        @Override
        protected void onPreExecute() {

//          mOutputText.setText("");
//          mProgress.show();
        }

        @Override
        protected void onPostExecute(Bitmap output) {

            if (output != null){
                bmImage.setImageBitmap(output);
            }
//            mProgress.hide();
//            if (output == null || output.size() == 0) {
//                mOutputText.setText("No results returned.");
//            } else {
//                output.add(0, "Data retrieved using the Drive API:");
//                mOutputText.setText(TextUtils.join("\n", output));
//            }
        }

        @Override
        protected void onCancelled() {
//            mProgress.hide();
//            if (mLastError != null) {
//                if (mLastError instanceof GooglePlayServicesAvailabilityIOException) {
//                    showGooglePlayServicesAvailabilityErrorDialog(
//                            ((GooglePlayServicesAvailabilityIOException) mLastError)
//                                    .getConnectionStatusCode());
//                } else if (mLastError instanceof UserRecoverableAuthIOException) {
//                    startActivityForResult(
//                            ((UserRecoverableAuthIOException) mLastError).getIntent(),
//                            MainActivity.REQUEST_AUTHORIZATION);
//                } else {
//                    mOutputText.setText("The following error occurred:\n"
//                            + mLastError.getMessage());
//                }
//            } else {
//                mOutputText.setText("Request cancelled.");
//            }
//        }
    }

}


