var quick_application = "http://192.168.1.106:8081/"
module.exports={
    registerUser: quick_application + "user/register",
    updateUser: quick_application + "user/update/userinfo",

    getFigure: quick_application + "user/figure/get",
    updateFigure: quick_application + "user/figure/update",

    putInCloset: quick_application + "cloth/closet/put",
    getUserCloset: quick_application + "cloth/closet/get",
    deleteClothFromCloset: quick_application + "cloth/closet/delete",

    distinguish: quick_application + "cloth/distinguish",
    getCloth: quick_application + "cloth/get/one",

    generateOutfitByCloset: quick_application + "recommend/closet",
    generateOutfitByCloth: quick_application + "recommend/cloth",

    getWeather: quick_application + "system/weather"
}