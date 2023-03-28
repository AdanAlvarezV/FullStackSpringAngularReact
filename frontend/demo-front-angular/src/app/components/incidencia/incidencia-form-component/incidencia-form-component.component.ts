import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Incidencia } from 'src/app/models/Incidencia';
import { Persona } from 'src/app/models/Persona';
import { IncidenciaService } from 'src/app/services/incidencia.service';
import { PersonaService } from 'src/app/services/persona.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-incidencia-form-component',
  templateUrl: './incidencia-form-component.component.html',
  styleUrls: ['./incidencia-form-component.component.css']
})
export class IncidenciaFormComponentComponent implements OnInit {

  titulo:string = "Nueva Incidencia";//TODO Cambiar titulo al cargar objeto para editar
  incidencia: Incidencia = new Incidencia();
  error:any;
  personas:Persona[] = [];

  reporta:Persona = new Persona();
  reportado:Persona = new Persona();

  constructor(private incidenciaService:IncidenciaService,
              private personaService:PersonaService,
              private router:Router,
              private route: ActivatedRoute) {
               }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id: number = +params.get('id');
      console.log("ID => " + id)
      if(id){
        this.incidenciaService.getById(id).subscribe(i => {
          this.incidencia = i;
          console.log(this.incidencia);

          if(this.incidencia.reporta){
            this.reporta = i.reporta;
          }
          else{
            this.reporta = new Persona();
          }

          if(this.incidencia.reportado){
            this.reportado = i.reportado;
          } else {
            this.reportado = new Persona();
          }

          this.titulo = "Editar Incidencia";
        });
      } else {
        this.titulo = "Crear Incidencia";
        this.reporta = new Persona();
        this.reportado = new Persona();
      }
    });

    this.personaService.getByStatus(true)
      .subscribe(p => {
        this.personas = p;
      });
  }

  asignarReporta(){
    this.incidencia.reporta = this.reporta;
  }

  asignarReportado(){
    this.incidencia.reportado = this.reportado;
  }

  crear(){
    this.incidenciaService.crearIncidencia(this.incidencia)
      .subscribe(incidencia => {
        console.log(incidencia);
        Swal.fire('Nuevo:', `Incidencia ${incidencia.id} creado con éxito`, 'success');
        this.router.navigate(['/incidencia']);
      },
      err => {
        console.log(err);
        if(err.status === 400){
          this.error = err.error;
          console.log(this.error);
        }
      })
  }

  editar(){
    this.incidenciaService.updateIncidencia(this.incidencia, this.incidencia.id)
      .subscribe(incidencia => {
        Swal.fire("Modificado:", `Incidencia ${incidencia.id} actualizado con éxito`, 'success');
        this.router.navigate(['/incidencia']);
      },
      err => {
        console.log(err);
        if(err.status === 400){
          this.error = err.error;
          console.log(this.error);
        }
      })
  }
}
