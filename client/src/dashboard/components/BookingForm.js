import React from "react";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Container from "react-bootstrap/Container";
import { Link } from "react-router-dom";

class BookingForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      schedules: [],
      pickUpLocation: " ",
      returnLocation: " ",
      pickUpDate: "",
      dropOffDate: "",
    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleInputChange = this.handleInputChange.bind(this);
  }

  handleInputChange(event) {
    const name = event.target.name;
    const value = event.target.value;
    this.setState({
      [name]: value,
    });
  }
  handleSubmit(event) {
    event.preventDefault();
    console.log(
      this.state.pickUpDate +
        "/" +
        this.state.dropOffDate +
        "/" +
        this.state.pickUpLocation +
        "/" +
        this.state.returnLocation
    );

    var scheduleFormData = {
      pickUpDate: this.state.pickUpDate,
      dropOffDate: this.state.dropOffDate,
      pickUpLocation: this.state.pickUpLocation,
      returnLocation: this.state.returnLocation,
    };
    localStorage.setItem("formdata", JSON.stringify(scheduleFormData));
    var test = JSON.parse(localStorage.getItem("formdata"));
    console.log(test);
  }

  render() {
    return (
      <Container fluid className="bookingForm">
       
          <Form onSubmit={this.handleSubmit}>
            <Form.Row>
              <Col>
              <Form.Label> Pick-Up Date</Form.Label>
                
                  <input
                    type="date"
                    name="pickUpDate"
                    value={this.state.pickUpDate}
                    onChange={this.handleInputChange}
                  />
               
              </Col>
              <Col>
              <Form.Label> Drop Off Date</Form.Label>
                  <input
                    type="date"
                    name="dropOffDate"
                    value={this.state.dropOffDate}
                    onChange={this.handleInputChange}
                  />
                
              </Col>
            </Form.Row>
            <Form.Row>
              <Col>
                <Form.Label>Pick-Up Location</Form.Label>
                <Form.Control
                  as="select"
                  value={this.state.pickUpLocation}
                  name="pickUpLocation"
                  onChange={this.handleInputChange}
                >
                  <option value="Indore">Indore</option>
                  <option value="New Delhi">New Delhi</option>
                  <option value="Mumbai">Mumbai</option>
                  <option value="Bangalore">Bangalore</option>
                </Form.Control>
              </Col>
              <Col>
                <Form.Label>Return Location</Form.Label>
                <Form.Control
                  as="select"
                  value={this.state.returnLocation}
                  name="returnLocation"
                  onChange={this.handleInputChange}
                >
                  <option value="Indore">Indore</option>
                  <option value="New Delhi">New Delhi</option>
                  <option value="Mumbai">Mumbai</option>
                  <option value="Bangalore">Bangalore</option>
                </Form.Control>
              </Col>
            </Form.Row>
            <Form.Row>
            <Link to="/results">
              <input type="submit" value="Find" onClick={this.onSubmit} />
            </Link>
            </Form.Row>
          </Form>
       
      </Container>
      
    );
  }
}

export default BookingForm;
