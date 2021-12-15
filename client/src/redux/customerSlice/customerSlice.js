import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";
import { Message } from "semantic-ui-react";
import CustomerService from "../../api/customerService";
const customerService = new CustomerService();

// export const logCustomerIn = createAsyncThunk(
//   "customer/logCustomerIn",
//   async (credentials) => {
//     const response = await axios.post(
//       `https://springrestapi-carrental.herokuapp.com/api/login?email=${credentials.email}&password=${credentials.password}`
//     );
//     return response.data.success;
//   }
// );
export const getCustomers = createAsyncThunk(
  "customer/getCustomers",
  async () => {
    const response = await customerService.getAll();
    return response.data.data;
  }
);

export const getCustomerByEmail = createAsyncThunk(
  "customer/getCustomerById",
  async (email) => {
    const response = await customerService.getCustomerByEmail(email);
    return response.data.success;
  }
);

export const activateCustomer = createAsyncThunk(
  "customer/activateCustomer",
  async (customer) => {
    await axios.post(
      //`https://springrestapi-carrental.herokuapp.com/api/register/activateCustomer?enteredActivationCode=${customer.activationCode}&customerId=${customer.id}`
        'http://localhost:8080/user/users'
      );
  }
);
// export const sendActivationCode = createAsyncThunk(
//     'customer/sendActivationCode',
//     async(infos)=>{
//        const response = await axios.post(`https://springrestapi-carrental.herokuapp.com/api/register/sendActivationCode?companyName=${infos.companyName}&email=${infos.email}&firstName=${infos.firstName}&lastName=${infos.lastName}&password=${infos.password}`)
       
//        return response.data
//     }
// )
export const userRegister=(reqObj)=>async dispatch=>{

  dispatch({type: 'LOADING' , payload:true})
  try{
    const response = await axios.post('http://localhost:8080/user/users', reqObj)
    dispatch({type: 'LOADING' , payload:false})
    Message.success('Registration Successful')
  }
  catch (error){
    console.log(error)
    Message.success('Something went wrong')
    dispatch({type: 'LOADING' , payload:false})
  }
}
export const userLogin=(reqObj)=>async dispatch=>{

  dispatch({type: 'LOADING' , payload:true})
  try{
    const response = await axios.post('http://localhost:8085/users/{username}/{password}', reqObj)
    dispatch({type: 'LOADING' , payload:false})
    Message.success('Login Successful')
  }
  catch (error){
    console.log(error)
    Message.success('Something went wrong')
    dispatch({type: 'LOADING' , payload:false})
  }
}
export const customerSlice = createSlice({
  name: "customer",
  initialState: {
    items: [],
    currentCustomer: null,
    admin:false,
    loggedIn: false,
    message: "",
    isActivated: false,
    activationCodeSent:false,
    activationCodeSentMessage:'',
  },
  reducers: {
    setCurrentCustomer: (state, action) => {
      state.currentCustomer = action.payload;
    },
    setLoggedInFalse: (state) => {
      state.loggedIn = false;
    },
    logCustomerOut: (state) => {
      state.currentCustomer = null;
    },
    setActivationCodeSentFalse:(state)=>{
        state.activationCodeSent=false
        state.activationCodeSentMessage=''
    }
  },
  // extraReducers: {
  //   [logCustomerIn.fulfilled]: (state, action) => {
  //     state.loggedIn = action.payload;
  //     if (action.payload === true) {
  //       state.message = "Logged in successfully";
        
  //     } else {
  //       state.message = "Can't logged in, please check the infos and try again";
  //     }
  //   },
  //   [getCustomers.fulfilled]: (state, action) => {
  //     state.items = action.payload;
  //   },
  //   [getCustomerByEmail.fulfilled]: (state, action) => {
  //     state.currentCustomer = action.payload;
  //   },
  //   // [sendActivationCode.fulfilled]:(state, action)=>{
  //   //     state.activationCodeSent= action.payload.success
  //   //     state.activationCodeSentMessage= action.payload.message
  //   // }
  // },
});

export const { setCurrentCustomer, setLoggedInFalse, logCustomerOut, setActivationCodeSentFalse } =
  customerSlice.actions;
export default customerSlice.reducer;
