package com.projecthope.content.error;

public interface ErrorCodes {

    ErrorCodes UNKNOWN_ERROR_CODE = UnknownErrorCode.INSTANCE;
    ErrorCodes FILE_UPLOAD_ERROR = CustomErrorCodes.FILE_UPLOAD_ERROR;
    ErrorCodes FILE_DOWNLOAD_ERROR = CustomErrorCodes.FILE_DOWNLOAD_ERROR;

    String code();

    enum CustomErrorCodes implements ErrorCodes {

        FILE_UPLOAD_ERROR,
        FILE_DOWNLOAD_ERROR;

        @Override
        public String code() {
            return this.name();
        }

    }

    enum UnknownErrorCode implements ErrorCodes {

        INSTANCE;

        @Override
        public String code() {
            return "unknown";
        }
    }

}
