package com.bao.retrofit2;

import com.google.gson.annotations.SerializedName;

public class JSONResponse {
    // đối với json thì mỗi key là tương ứng với thuộc tính bên trong class
    // còn giá trị của key tương ứng với kiểu dữ liệu của thuộc tính đó bên trong class

//    cụ thể mình có 1 json bên dưới để nhận đc json này ta tạo 1 class có 1 thuộc tính
//    là moviz và có kiểu dữ liệu là 1 mảng đúng chưa! và mảng này có kiểu là movie
// bởi vì mỗi thành phần trong mảng là 1 json và mỗi json này tương ứng với class movie
    /*
{
  "moviz":
  [
    {
      "id": 1,
      "name": "John Doe",
      "image": "https://bggamingzone.com/wp-content/uploads/2024/11/ss_ef0725b0623dc26ab21061fb78b9b75db03285a6.600x338-450x253.jpg"
    },
    {
      "id": 2,
      "name": "Jane Smith",
      "image": "https://bggamingzone.com/wp-content/uploads/2024/11/ss_0560a7121254cfddf4525ffa89a1114295d97ea1.1920x1080-450x253.jpg"
    },
    {
      "id": 3,
      "name": "Alice Johnson",
      "image": "https://bggamingzone.com/wp-content/uploads/2024/10/989770-300x169.jpg"
    }
  ]
}
    * */
    private Movie[] moviz;

    public Movie[] getMoviz() {
        return moviz;
    }

    public void setMoviz(Movie[] moviz) {
        this.moviz = moviz;
    }
}
