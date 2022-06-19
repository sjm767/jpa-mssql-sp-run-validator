CREATE PROCEDURE dbo.sample_codegen_delete
(
	@id int =0

)

	AS

    set nocount on
    set transaction isolation level read uncommitted

	DELETE FROM dbo.SAMPLE_TEST_TBL
	WHERE ID = @id
