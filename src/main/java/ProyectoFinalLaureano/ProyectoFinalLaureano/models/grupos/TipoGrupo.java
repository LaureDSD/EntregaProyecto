package ProyectoFinalLaureano.ProyectoFinalLaureano.models.grupos;

public enum TipoGrupo {
    GREMIO(100),
    INCURSION(10),
    PARTY(4);

    private int limitePersoanjes;

    TipoGrupo(int limitePersoanjes) {
        this.limitePersoanjes = limitePersoanjes;
    }
}
