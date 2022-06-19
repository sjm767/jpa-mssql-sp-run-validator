CREATE PROCEDURE dbo.sample_codegen_select
(	
	@id int,
	@username varchar(10)
	
)

	AS

    set nocount on
    set transaction isolation level read uncommitted


	SELECT STT.ID AS ID
	,	STT.NAME AS USERNAME
	,	STT.AGE AS AGE
	FROM dbo.SAMPLE_TEST_TBL STT WITH(NOLOCK)
	WHERE STT.ID = @ID
	AND STT.NAME=@USERNAME
