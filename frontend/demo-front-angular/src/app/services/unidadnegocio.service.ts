import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BASE_ENDPOINT } from '../config/app';
import { UnidadNegocio } from '../models/UnidadNegocio';

@Injectable({
  providedIn: 'root'
})
export class UnidadnegocioService {

  baseEndpoint: string = BASE_ENDPOINT + "/unidadnegocio";
  //protected cabeceras: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json', 'Accept': 'application/json'});
  cabeceras: HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});

  constructor(private http: HttpClient) { }

  public getAllUnidades(): Observable<UnidadNegocio[]>{
    return this.http.get<UnidadNegocio[]>(this.baseEndpoint);
  }
  
  public getByStatus(status:boolean): Observable<UnidadNegocio[]>{
    return this.http.get<UnidadNegocio[]>(`${this.baseEndpoint}/status/${status}`);
  }

  public getById(id:number):Observable<UnidadNegocio>{
    return this.http.get<UnidadNegocio>(`${this.baseEndpoint}/${id}`);
  }

  public crearUnidadNegocio(unidad:UnidadNegocio): Observable<UnidadNegocio>{
    unidad.status = true;
    return this.http.post<UnidadNegocio>(`${this.baseEndpoint}`,unidad,
    {headers: this.cabeceras});
  }

  public updateUnidadNegocio(unidad:UnidadNegocio, id:number): Observable<UnidadNegocio>{
    console.log(`${this.baseEndpoint}/${id}`);
    return this.http.put<UnidadNegocio>(`${this.baseEndpoint}/${id}`, unidad, {headers: this.cabeceras});
  }

  public deleteUnidadNegocio(id:number): Observable<UnidadNegocio>{
      return  this.http.delete<UnidadNegocio>(`${this.baseEndpoint}/${id}`);
  }
}
