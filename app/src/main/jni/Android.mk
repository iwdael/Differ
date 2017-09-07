LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES:= com_absurd_packageupdata_PackageUpdata.cpp

LOCAL_MODULE:= packageupdata
include $(BUILD_SHARED_LIBRARY)
