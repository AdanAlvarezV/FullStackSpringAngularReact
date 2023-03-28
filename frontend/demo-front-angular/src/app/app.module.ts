import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './layout/navbar/navbar.component';
import { HomeComponent } from './components/home/home/home.component';
import { UnidadNegocioListComponentComponent } from './components/unidadnegocio/unidad-negocio-list-component/unidad-negocio-list-component.component';
import { UnidadNegocioFormComponentComponent } from './components/unidadnegocio/unidad-negocio-form-component/unidad-negocio-form-component.component';
import { PersonaListComponentComponent } from './components/persona/persona-list-component/persona-list-component.component';
import { PersonaFormComponentComponent } from './components/persona/persona-form-component/persona-form-component.component';
import { FormsModule } from '@angular/forms';
import { IncidenciaListComponentComponent } from './components/incidencia/incidencia-list-component/incidencia-list-component.component';
import { IncidenciaFormComponentComponent } from './components/incidencia/incidencia-form-component/incidencia-form-component.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    UnidadNegocioListComponentComponent,
    UnidadNegocioFormComponentComponent,
    PersonaListComponentComponent,
    PersonaFormComponentComponent,
    IncidenciaListComponentComponent,
    IncidenciaFormComponentComponent,
    IncidenciaListComponentComponent,
    IncidenciaFormComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
