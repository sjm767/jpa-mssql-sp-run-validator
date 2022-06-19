CREATE PROCEDURE dbo.sample_codegen_selectvalue
(	
	@id int,
	@username varchar(10)
	
)

	AS

    set nocount on
    set transaction isolation level read uncommitted
	
	SELECT 'VALUE1' AS RET_VALUE
