import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Persona } from 'src/app/models/Persona';
import { UnidadNegocio } from 'src/app/models/UnidadNegocio';
import { PersonaService } from 'src/app/services/persona.service';
import { UnidadnegocioService } from 'src/app/services/unidadnegocio.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-unidad-negocio-form-component',
  templateUrl: './unidad-negocio-form-component.component.html',
  styleUrls: ['./unidad-negocio-form-component.component.css']
})
export class UnidadNegocioFormComponentComponent implements OnInit {

  titulo:string = "Nueva unidad de negocio";//TODO Cambiar titulo al cargar objeto para editar
  unidadNegocio: UnidadNegocio = new UnidadNegocio();
  error:any;
  unidades:UnidadNegocio[] = [];
  personas:Persona[] = [];

  unidadPadre:UnidadNegocio = new UnidadNegocio();
  gerente:Persona = new Persona();

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
        this.unidadService.getById(id).subscribe(u => {
          this.unidadNegocio = u;
          console.log(this.unidadNegocio);
          if(this.unidadNegocio.unidadPadre){
            this.unidadPadre = u.unidadPadre;
          }
          else{
            this.unidadPadre = new UnidadNegocio();
          }
          if(this.unidadNegocio.gerente){
            this.gerente = u.gerente;
          } else {
            this.gerente = new Persona();
          }

          this.titulo = "Editar Unidad de negocio";
        });
      } else {
        this.titulo = "Crear Unidad de negocio";
        this.unidadPadre = new UnidadNegocio();
        this.gerente = new Persona();
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

  asignarPadre(){
    this.unidadNegocio.unidadPadre = this.unidadPadre;
  }

  asignarGerente(){
    this.unidadNegocio.gerente = this.gerente;
  }

  crear(){
    this.unidadService.crearUnidadNegocio(this.unidadNegocio)
      .subscribe(unidad => {
        console.log(unidad);
        Swal.fire('Nuevo:', `Unidad de negocio ${unidad.nombre} creado con éxito`, 'success');
        this.router.navigate(['/unidadnegocio']);
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
    this.unidadService.updateUnidadNegocio(this.unidadNegocio, this.unidadNegocio.id)
      .subscribe(unidad => {
        Swal.fire("Modificado:", `Unidad de negocio ${unidad.nombre} actualizado con éxito`, 'success');
        this.router.navigate(['/unidadnegocio']);
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
