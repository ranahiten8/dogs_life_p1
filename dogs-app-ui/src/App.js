import './App.css';
import AllDogs from './components/AllDogs';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import ModifyDogForm from './components/ModifyDogForm';
import {Route, Routes} from 'react-router-dom';

function App() {
  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand href="/">Dogs</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link href="/alldogs">All Dogs</Nav.Link>
              <Nav.Link href="/modifydog">Modify Dogs</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>

      <Routes>
          <Route path="alldogs" element={<AllDogs/>} />
          <Route path="modifydog" element={<ModifyDogForm/>} />
          <Route path="/" element={<AllDogs/>} />
        </Routes>
    </>
  );
}

export default App;
