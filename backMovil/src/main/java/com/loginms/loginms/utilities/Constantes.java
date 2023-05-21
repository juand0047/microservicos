package com.loginms.loginms.utilities;

public class Constantes {

    /**
     * Urls
     */
    public final class Urls {
        /**
         * Coonstante PATH_USUARIO
         */
        public final static String PATH_USUARIO = "usuario";
        /**
         * Coonstante PATH_USUARIO_USER
         */
        public final static String PATH_USUARIO_USER = "{usuario}";
        /**
         * Coonstante PATH_DESCRIP
         */
        public final static String PATH_DESCRIP = "descripcion";
        /**
         * Coonstante PATH_EXCEL
         */
        public final static String PATH_EXCEL = "excel";
        /**
         * Coonstante PATH_DESCRIP_ID
         */
        public final static String PATH_DESCRIP_ID = "{id}";
        /**
         * Coonstante PATH_DESCRIP_GASTO
         */
        public final static String PATH_DESCRIP_GASTO = "lista/gasto";
        /**
         * Coonstante PATH_DESCRIP_INGRESO
         */
        public final static String PATH_DESCRIP_INGRESO = "lista/ingreso";
        /**
         * Coonstante PATH_CONTABILIDAD
         */
        public final static String PATH_CONTABILIDAD = "contabilidad";
        /**
         * Coonstante PATH_CONTABILIDAD_ID
         */
        public final static String PATH_CONTABILIDAD_ID = "{idContabilidad}";
        /**
         * Coonstante PATH_CATEGORIA
         */
        public final static String PATH_CATEGORIA = "categoria";
        /**
         * Coonstante PATH_CATEGORIA_ID
         */
        public final static String PATH_CATEGORIA_ID = "{idCategoria}";
        /**
         * Coonstante PATH_OPER_BASICAS
         */
        public final static String PATH_OPER_BASICAS = "operaciones/basicas";
        /**
         * Coonstante PATH_OPER_BASICAS_USUARIO_GAST
         */
        public final static String PATH_OPER_BASICAS_USUARIO_GAST = "gasto/total/{usuario}";
        /**
         * Coonstante PATH_OPER_BASICAS_USUARIO_INGRE
         */
        public final static String PATH_OPER_BASICAS_USUARIO_INGRE = "ingreso/total/{usuario}";
        /**
         * Coonstante PATH_OPER_BASICAS_USUARIO_GASTS
         */
        public final static String PATH_OPER_BASICAS_USUARIO_GASTS = "gastos/{usuario}/{pag}/{cant}";
        /**
         * Coonstante PATH_OPER_BASICAS_USUARIO_INGRES
         */
        public final static String PATH_OPER_BASICAS_USUARIO_INGRES = "ingresos/{usuario}/{pag}/{cant}";
        /**
         * Coonstante PATH_OPER_BASICAS_DISPO_USUARIO
         */
        public final static String PATH_OPER_BASICAS_DISPO_USUARIO = "disponible/{usuario}";
        /**
         * Coonstante PATH_LOGIN
         */
        public final static String PATH_LOGIN = "login";
        /**
         * Coonstante PATH_CATEGORIA_ID
         */
        public final static String PATH_CATEGORIA_ID_CATE = "total-gastos/{idCategoria}";

        private Urls() {
        }
    }

}
