import { UnidadNegocio } from "./UnidadNegocio";

export class Persona {
    id: number;
    nombre: string;
    unidadNegocio: UnidadNegocio = null;
    supervisor: Persona = null;
    //subordinados: Persona[] = [];
    status: boolean;

}