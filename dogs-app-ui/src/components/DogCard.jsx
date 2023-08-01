import React from 'react'
import { Button, Card, Row, Col } from 'react-bootstrap';
import images from '../index';

const DogCard = (props) => {
    const deleteDog =()=>{
        props.deleteFunction(props.info.id);
    }
  return (
    <>
    <Card >
     <div className="imgContainer">
        <Card.Img variant="top" src={images[props.info.id]} />
      </div>
      <Card.Body >
        <Row>
            <Col>
                <Card.Title >Id: {props.info.id}</Card.Title>
                <Card.Text >Name: {props.info.name}</Card.Text>
            </Col>
            <Col>
                <Button variant="primary" onClick={deleteDog}>Delete</Button>   
            </Col>
        </Row>
      </Card.Body>
    </Card>
    </>
  )
}

export default DogCard