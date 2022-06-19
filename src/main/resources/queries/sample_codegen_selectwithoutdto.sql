CREATE PROCEDURE dbo.sample_codegen_selectwithoutdto
(	
	@id int,
	@username varchar(10)
	
)

	AS

    set nocount on
    set transaction isolation level read uncommitted
	
	SELECT 'VALUE_1' AS VALUE
