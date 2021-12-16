import { useEffect } from "react";
import { useSelector } from "react-redux";
import { Route } from "react-router";
import { Container } from "semantic-ui-react";
import "./App.css";

import FilterBar from "./components/Filter/FilterBar";
import FilterIcon from "./components/Filter/FilterIcon";

import NavigationBar from "./components/NavigationBar/NavigationBar";
import AddCarPage from "./pages/AddCarPage";
import FilteredCarsPage from "./pages/FilteredCarsPage";
import ProfilePage from "./pages/ProfilePage";
import RentalHistoryPage from "./pages/RentalHistoryPage";
import SignInPage from "./pages/SignInPage";
import SignUpPage from "./pages/SignUpPage";

function App() {
  const isDropped = useSelector((state) => state.filter.isDropped);

  return (
    <div className="App">
      <NavigationBar></NavigationBar>
      
      <Container style={{ display: "flex", marginTop: "2em" }}>
        <Route exact path="/">
          {isDropped ? <FilterBar></FilterBar> : <FilterIcon></FilterIcon>}
        </Route>

        <Route path='/filter/'>
          <FilteredCarsPage></FilteredCarsPage>
        </Route>
        <Route exact path="/signin">
          <SignInPage></SignInPage>
        </Route>
        <Route exact path="/signup">
          <SignUpPage></SignUpPage>
        </Route>
        <Route exact path="/profile/:email">
          <ProfilePage></ProfilePage>
        </Route>
        <Route exact path="/add-car">
          <AddCarPage></AddCarPage>
        </Route>
        <Route exact path="/rental-history/:email">
    <RentalHistoryPage></RentalHistoryPage>
        </Route>
        
      </Container>
    </div>
  );
}

export default App;
