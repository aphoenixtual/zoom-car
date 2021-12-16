import axios from "axios";

export default class CarService {
    getAllCars(){
        console.log("getallcars ")
        return axios.get("http://localhost:8080/car/cars/getAll")
    }
    getCarById(id){
        console.log("getCarById")
        return axios.get("http://localhost:8080/car/cars/getCarById?id="+id)
    }
    getCarsDetails(){
        console.log("getCarsDet1ails")
        return axios.get("http://localhost:8080/car/cars/getCarDetails")
    }
    getCarsByBrandId(id){
        console.log("getCarsByBrandId")
        return axios.get("http://localhost:8080/car/cars/getCarsByBrandId?id="+id)
    }
    getCarsByColorId(id){
        console.log("getCarsByColorId")
        return axios.get("http://localhost:8080/cars/getCarsByColorId?id="+id)
    }
    deleteByCarId(id){
        return axios.delete("http://localhost:8080/car/cars/delete?id="+ id)
    }
    addCar(newCar){
        return 
    }
    addCarImage(){

    }
}