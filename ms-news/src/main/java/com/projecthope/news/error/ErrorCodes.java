package com.projecthope.news.error;

public interface ErrorCodes {

    ErrorCodes UNKNOWN_ERROR_CODE = UnknownErrorCode.INSTANCE;
    ErrorCodes NEWS_NOT_FOUND = CustomErrorCodes.NEWS_NOT_FOUND;

    String code();

    enum CustomErrorCodes implements ErrorCodes {

        NEWS_NOT_FOUND;

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
