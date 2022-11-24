import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './layout/Navbar';
import Home from './pages/Home';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AddUser from './models/users/AddUser';
import AddObra from './models/obras/AddObra';
import ViewObra from './models/obras/ViewObra';
import EditObra from './models/obras/EditObra';
import AddObraLocal from './models/obraLocalizacao/AddObraLocal';
import ViewObraLocal from './models/obraLocalizacao/ViewObraLocal';
import EditObraLocal from './models/obraLocalizacao/EditObraLocal';
import AddObraDetalhes from './models/obraDetalhesTecnicos/AddObraDetalhes';
import ViewObraDetalhes from './models/obraDetalhesTecnicos/ViewObraDetalhes';
import EditObraDetalhes from './models/obraDetalhesTecnicos/EditObraDetalhes';
import AddObraInspecao from './models/obraInspecao/AddObraInspecao';
import ViewObraInspecao from './models/obraInspecao/ViewObraInspecao';
import EditObraInspecao from './models/obraInspecao/EditObraInspecao';
import AddInspecao from './models/Inspecao/AddInspecao';
import ViewInspecao from './models/Inspecao/ViewInspecao';
import EditInspecao from './models/Inspecao/EditInspecao';
import Login from './pages/login';
import ViewObraId from './models/obras/ViewObraId';
import ViewObraLocalById from './models/obraLocalizacao/ViewObraLocalById';
import ViewObraInspecaoByID from './models/obraInspecao/ViewObraInspecaoByID';
import ViewDetalhesObrasById from './models/obraDetalhesTecnicos/ViewDetalhesObrasById';
import ViewInspecaoById from './models/Inspecao/ViewInspecaoById';


function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/login" element={<Login />} />

          <Route exact path="/" element={<Home />} />
          
          <Route exact path="/adduser" element={<AddUser />} />



          <Route exact path="/addobra" element={<AddObra />} />
          <Route exact path="/editobra/:id" element={<EditObra />} />
          <Route exact path="/viewobra" element={<ViewObra />} />
          <Route exact path="/viewobraid/:id" element={<ViewObraId />} />


          <Route exact path="/addobralocal" element={<AddObraLocal />} />
          <Route exact path="/viewobralocal" element={<ViewObraLocal />} />
          <Route exact path="/viewobralocalid/:id" element={<ViewObraLocalById />} />
          <Route exact path="/editobralocal/:id" element={<EditObraLocal />} />


          <Route exact path="/addobradetalhes" element={<AddObraDetalhes />} />
          <Route exact path="/viewobradetalhes" element={<ViewObraDetalhes />} />
          <Route exact path="/editobradetalhes/:id" element={<EditObraDetalhes />} />
          <Route exact path="/viewobradetalheid/:id" element={<ViewDetalhesObrasById />} />



          <Route exact path="/addobrainspecao" element={<AddObraInspecao />} />
          <Route exact path="/viewobrainspecao" element={<ViewObraInspecao />} />
          <Route exact path="/viewobrainspecaoid/:id" element={<ViewObraInspecaoByID />} />
          <Route exact path="/editobrainspecao/:id" element={<EditObraInspecao />} />


          <Route exact path="/addinspecao" element={<AddInspecao />} />
          <Route exact path="/viewinspecao" element={<ViewInspecao />} />
          <Route exact path="/editinspecao/:id" element={<EditInspecao />} />
          <Route exact path="/viewobrainspecaoid/:id" element={<ViewInspecaoById />} />



        </Routes>
      </Router>

    </div>
  );
}

export default App;
