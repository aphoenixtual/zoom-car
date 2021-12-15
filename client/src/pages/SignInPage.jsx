import axios from "axios";
import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router";
import { Link } from "react-router-dom";
import Logo from "../components/NavigationBar/Logo";
import {
  getCustomers,
  logCustomerIn,
  setCurrentCustomer,
  setLoggedInFalse,
} from "../redux/customerSlice/customerSlice";

function SignInPage() {
  const dispatch = useDispatch();
  const history = useHistory()
  const [username, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const customers = useSelector((state) => state.customer.items);
  const loggedIn = useSelector((state) => state.customer.loggedIn);
 
  useEffect(() => {
    if (loggedIn) {
      customers.forEach((customer) => {
        if (customer.username == username) {
          dispatch(setCurrentCustomer(customer));
        }
      });
      
      history.push("/")
      dispatch(setLoggedInFalse())
    }
  }, [loggedIn]);

  useEffect(() => {
    dispatch(getCustomers());
  }, [dispatch]);

  async function submitHandler(values){
    const response = await axios.post('http://localhost:8080/user/users/{username}/{password}',{
           username,
           password,
           history,
           customers,
           loggedIn
          
    })
    console.log(response)
   }

  return (
    <div style={{ marginLeft: "auto", marginRight: "auto" }}>
      <div className="signinpage">
        <div
          style={{
            background: "#C3073F",
            width: "100%",
            height: "4.5rem",
            borderRadius: "10px 10px 0px 0px",
          }}
        >
          <Logo></Logo>
        </div>
        <div style={{ padding: 50 }}>
          <h4 style={{ textAlign: "left", fontSize: 20, color: "white" }}>
            Username
          </h4>
          <input
            autoComplete="false"
            autoCapitalize="false"
            onChange={(e) => setUserName(e.target.value)}
            type="username"
            style={{
              borderRadius: "5px",
              width: "100%",
              height: "3em",
              padding: 20,
              letterSpacing: 2,
              fontWeight: "bold",
            }}
          ></input>
          <h4 style={{ textAlign: "left", fontSize: 20, color: "white" }}>
            Password
          </h4>
          <input
            type="password"
            onChange={(e) => setPassword(e.target.value)}
            style={{
              borderRadius: "5px",
              width: "100%",
              height: "3em",
              padding: 20,
              letterSpacing: 2,
              fontWeight: "bold",
            }}
          ></input>

          <button onClick={submitHandler} className="signinbutton">
            Sign In
          </button>

          <p
            style={{
              color: "white",
              opacity: "80%",
              letterSpacing: "1px",
              fontSize: 16,
              marginTop: 40,
            }}
          >
            <Link to='/signup'> Click here to register </Link>
          </p>
        </div>
      </div>
    </div>
    
  );
}

export default SignInPage;
