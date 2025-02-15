package ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos;

public enum TipoGrupoEnum {
    GREMIO(100),
    INCURSION(10),
    PARTY(4);

    private int limitePersoanjes;

    TipoGrupoEnum(int limitePersoanjes) {
        this.limitePersoanjes = limitePersoanjes;
    }
}
