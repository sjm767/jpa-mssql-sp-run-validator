CREATE PROCEDURE dbo.sample_codegen_selectvaluelist
(	
	@id int,
	@username varchar(10)
	
)

	AS

    set nocount on
    set transaction isolation level read uncommitted
	
	SELECT 'VALUE1' AS RET_VALUE

	UNION ALL

	SELECT 'VALUE2' AS RET_VALUE

