package com.team.foodchain

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.PermissionRequest

class RefTab : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_my_ref, container, false)
        return v
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        ButterKnife.bind(this)
//        fabCapturePhoto?.setOnClickListener { validatePermissions() }
//    }
//
//    private fun validatePermissions() {
//        Dexter.withActivity(this)
//                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .withListener(object: PermissionListener {
//                    override fun onPermissionGranted(
//                            response: PermissionGrantedResponse?) {
//                        launchCamera()
//                    }
//
//                    override fun onPermissionRationaleShouldBeShown(
//                            permission: PermissionRequest?,
//                            token: PermissionToken?) {
//                        AlertDialog.Builder(this@MainActivity)
//                                .setTitle(
//                                        R.string.storage_permission_rationale_title)
//                                .setMessage(
//                                        R.string.storage_permition_rationale_message)
//                                .setNegativeButton(
//                                        android.R.string.cancel,
//                                        { dialog, _ ->
//                                            dialog.dismiss()
//                                            token?.cancelPermissionRequest()
//                                        })
//                                .setPositiveButton(android.R.string.ok,
//                                        { dialog, _ ->
//                                            dialog.dismiss()
//                                            token?.continuePermissionRequest()
//                                        })
//                                .setOnDismissListener({
//                                    token?.cancelPermissionRequest() })
//                                .show()
//                    }
//
//                    override fun onPermissionDenied(
//                            response: PermissionDeniedResponse?) {
//                        Snackbar.make(mainContainer!!,
//                                R.string.storage_permission_denied_message,
//                                Snackbar.LENGTH_LONG)
//                                .show()
//                    }
//                })
//                .check()
//    }
}
