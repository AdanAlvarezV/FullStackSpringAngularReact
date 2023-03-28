import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home/home.component';
import { IncidenciaFormComponentComponent } from './components/incidencia/incidencia-form-component/incidencia-form-component.component';
import { IncidenciaListComponentComponent } from './components/incidencia/incidencia-list-component/incidencia-list-component.component';
import { PersonaFormComponentComponent } from './components/persona/persona-form-component/persona-form-component.component';
import { PersonaListComponentComponent } from './components/persona/persona-list-component/persona-list-component.component';
import { UnidadNegocioFormComponentComponent } from './components/unidadnegocio/unidad-negocio-form-component/unidad-negocio-form-component.component';
import { UnidadNegocioListComponentComponent } from './components/unidadnegocio/unidad-negocio-list-component/unidad-negocio-list-component.component';


const routes: Routes = [
  {path: '', pathMatch:'full', redirectTo:'home'},
  {path: 'home', component:HomeComponent},
  {path: 'unidadnegocio', component:UnidadNegocioListComponentComponent},
  {path: 'unidadnegocio/form', component:UnidadNegocioFormComponentComponent},
  {path: 'unidadnegocio/form/:id', component:UnidadNegocioFormComponentComponent},
  {path: 'persona', component:PersonaListComponentComponent},
  {path: 'persona/form', component:PersonaFormComponentComponent},
  {path: 'persona/form/:id', component:PersonaFormComponentComponent},
  {path: 'incidencia', component:IncidenciaListComponentComponent},
  {path: 'incidencia/form', component:IncidenciaFormComponentComponent},
  {path: 'incidencia/form/:id', component:IncidenciaFormComponentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
