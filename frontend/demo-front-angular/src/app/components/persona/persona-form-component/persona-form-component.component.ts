import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/models/Persona';
import { UnidadNegocio } from 'src/app/models/UnidadNegocio';
import { PersonaService } from 'src/app/services/persona.service';
import { UnidadnegocioService } from 'src/app/services/unidadnegocio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-persona-form-component',
  templateUrl: './persona-form-component.component.html',
  styleUrls: ['./persona-form-component.component.css']
})
export class PersonaFormComponentComponent implements OnInit {

  titulo:string = "Nueva unidad de negocio";//TODO Cambiar titulo al cargar objeto para editar
  persona: Persona = new Persona();
  error:any;
  unidades:UnidadNegocio[] = [];
  personas:Persona[] = [];

  unidadNegocio:UnidadNegocio = new UnidadNegocio();
  supervisor:Persona = new Persona();

  constructor(private unidadService:UnidadnegocioService,
              private personaService:PersonaService,
              private router:Router,
              private route: ActivatedRoute) {
               }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id: number = +params.get('id');
      console.log("ID => " + id)
      if(id){
        this.personaService.getById(id).subscribe(p => {
          this.persona = p;
          console.log(this.persona);

          if(this.persona.unidadNegocio){
            this.unidadNegocio = p.unidadNegocio;
          }
          else{
            this.unidadNegocio = new UnidadNegocio();
          }

          if(this.persona.supervisor){
            this.supervisor = p.supervisor;
          } else {
            this.supervisor = new Persona();
          }

          this.titulo = "Editar Persona";
        });
      } else {
        this.titulo = "Crear Persona";
        this.unidadNegocio = new UnidadNegocio();
        this.supervisor = new Persona();
      }
    });

    this.unidadService.getByStatus(true)
      .subscribe(u => {
        this.unidades = u;
      });

    this.personaService.getByStatus(true)
      .subscribe(p => {
        this.personas = p;
      });
  }

  asignarUnidad(){
    this.persona.unidadNegocio = this.unidadNegocio;
  }

  asignarSupervisor(){
    this.persona.supervisor = this.supervisor;
  }

  crear(){
    this.personaService.crearPersona(this.persona)
      .subscribe(persona => {
        console.log(persona);
        Swal.fire('Nuevo:', `Persona ${persona.nombre} creado con éxito`, 'success');
        this.router.navigate(['/persona']);
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
    this.personaService.updatePersona(this.persona, this.persona.id)
      .subscribe(persona => {
        Swal.fire("Modificado:", `Persona ${persona.nombre} actualizado con éxito`, 'success');
        this.router.navigate(['/persona']);
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
