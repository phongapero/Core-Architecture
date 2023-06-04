package com.example.utils

class AdsUtils {

    /*val interBloodDetails: InterPriority = InterPriority()
    val interBloodInfo: InterPriority = InterPriority()
    val interMeasure: InterPriority = InterPriority()
    val interInfo: InterPriority = InterPriority()*/

   /* class InterPriority {
        private val TAG = InterPriority::class.java.name

        var interAdsPriority: ApInterstitialAd? = null
        var interAdsNormal: ApInterstitialAd? = null

        private fun interAdsPriorityLoaded(): Boolean =
            interAdsPriority?.interstitialAd != null && interAdsPriority!!.isReady

        private fun interAdsNormalLoaded(): Boolean =
            interAdsNormal?.interstitialAd != null && interAdsNormal!!.isReady

        private fun resetDataAds() {
            interAdsPriority = null
            interAdsNormal = null
        }

        fun checkAdsRepairedAll(): Boolean {
            if (interAdsPriorityLoaded() && interAdsNormalLoaded()) {
                return true
            }
            return false
        }

        private fun canShowAds(): Boolean {
            if (interAdsPriorityLoaded() || interAdsNormalLoaded()) {
                return true
            }
            return false
        }

        fun showInterAdsBeforeNavigate(context: Context, nextActionCallBack: (() -> Unit)) {
            val finishCallback: () -> Unit = run {
                { nextActionCallBack() }
            }
            if (canShowAds()) {
                if (interAdsPriorityLoaded() && !interAdsNormalLoaded()) {
                    AperoAd.getInstance().forceShowInterstitial(
                        context,
                        interAdsPriority,
                        object : AperoAdCallback() {
                            override fun onNextAction() {
                                super.onNextAction()
                                finishCallback()
                            }
                        },
                        false
                    )
                } else if (!interAdsPriorityLoaded() && interAdsNormalLoaded()) {
                    AperoAd.getInstance().forceShowInterstitial(
                        context,
                        interAdsNormal,
                        object : AperoAdCallback() {
                            override fun onNextAction() {
                                super.onNextAction()
                                finishCallback()
                            }
                        },
                        false
                    )
                } else {
                    AperoAd.getInstance().forceShowInterstitial(
                        context,
                        interAdsPriority,
                        object : AperoAdCallback() {
                            override fun onNextAction() {
                                super.onNextAction()
                                finishCallback()
                            }

                            override fun onAdFailedToShow(adError: ApAdError?) {
                                super.onAdFailedToShow(adError)

                                //show Normal Ads If fail Priority
                                AperoAd.getInstance().forceShowInterstitial(
                                    context,
                                    interAdsNormal,
                                    object : AperoAdCallback() {
                                        override fun onNextAction() {
                                            super.onNextAction()
                                            finishCallback()
                                        }
                                    },
                                    false
                                )
                            }
                        },
                        false
                    )
                }
            } else {
                finishCallback()
            }
        }

        fun loadInterPrioritySameTime(
            context: Context,
            idAdsPriority: String,
            idAdsNormal: String,
            isReloadFailAds: Boolean,
            listener: Listener?
        ) {
            if (isReloadFailAds) {
                resetDataAds()
            }
            AperoAd.getInstance()
                .getInterstitialAds(context, idAdsPriority, object : AperoAdCallback() {
                    override fun onInterstitialLoad(interstitialAd: ApInterstitialAd?) {
                        super.onInterstitialLoad(interstitialAd)
                        Log.d(TAG, "onInterstitialLoad: idAdsPriority")
                        interAdsPriority = interstitialAd
                        listener?.onAdsPriorityLoaded(interstitialAd)
                    }

                    override fun onAdFailedToLoad(adError: ApAdError?) {
                        super.onAdFailedToLoad(adError)
                        interAdsPriority = null
                        listener?.onAdsPriorityLoadFail(adError)
                    }
                })

            AperoAd.getInstance()
                .getInterstitialAds(context, idAdsNormal, object : AperoAdCallback() {
                    override fun onInterstitialLoad(interstitialAd: ApInterstitialAd?) {
                        super.onInterstitialLoad(interstitialAd)
                        Log.d(TAG, "onInterstitialLoad: idAdsNormal")
                        interAdsNormal = interstitialAd
                        listener?.onAdsNormalLoaded(interstitialAd)
                    }

                    override fun onAdFailedToLoad(adError: ApAdError?) {
                        super.onAdFailedToLoad(adError)
                        interAdsNormal = null
                        listener?.onAdsNormalLoadFail(adError)
                    }
                })
        }

        interface Listener {
            fun onAdsPriorityLoaded(interstitialAd: ApInterstitialAd?)

            fun onAdsPriorityLoadFail(adError: ApAdError?)

            fun onAdsNormalLoaded(interstitialAd: ApInterstitialAd?)

            fun onAdsNormalLoadFail(adError: ApAdError?)
        }
    }*/
}