package com.team.foodchain

data class GetProductResponse(
        var message:String,
        var data:ArrayList<Data>,
        var coupon:Coupon,
        var reco:ArrayList<Reco>
)

//6-1 home/main 최초.