import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BASE_ENDPOINT } from '../config/app';
import { Incidencia } from '../models/Incidencia';

@Injectable({
  providedIn: 'root'
})
export class IncidenciaService {

  baseEndpoint: string = BASE_ENDPOINT + "/incidencia";
  cabeceras: HttpHeaders = new HttpHeaders({'Content-Type':'application/json'});

  constructor(private http:HttpClient) { }

  public getAllIncidencias(): Observable<Incidencia[]>{
    return this.http.get<Incidencia[]>(this.baseEndpoint);
  }
  
  public getByStatus(status:boolean): Observable<Incidencia[]>{
    return this.http.get<Incidencia[]>(`${this.baseEndpoint}/status/${status}`);
  }

  public getById(id:number):Observable<Incidencia>{
    return this.http.get<Incidencia>(`${this.baseEndpoint}/${id}`);
  }

  public crearIncidencia(incidencia:Incidencia): Observable<Incidencia>{
    incidencia.status = "Nuevo";
    return this.http.post<Incidencia>(`${this.baseEndpoint}`,incidencia,
    {headers: this.cabeceras});
  }

  public updateIncidencia(incidencia:Incidencia, id:number): Observable<Incidencia>{
    console.log(`${this.baseEndpoint}/${id}`);
    return this.http.put<Incidencia>(`${this.baseEndpoint}/${id}`, incidencia, {headers: this.cabeceras});
  }

  public deleteIncidencia(id:number): Observable<Incidencia>{
      return this.http.delete<Incidencia>(`${this.baseEndpoint}/${id}`);
  }
}
