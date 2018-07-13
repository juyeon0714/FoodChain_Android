package com.team.foodchain

data class CateData(
        var pro_idx:Int,
        var pro_name:String,
        var pro_price:Int,
        var pro_sale_price:Int,
        var pro_info:String,
        var mar_idx:Int,
        var pro_img:ArrayList<CateImage>,
        var dist:String)

//6-2 홈에서 카테고리선택하면 뜨는 마켓들