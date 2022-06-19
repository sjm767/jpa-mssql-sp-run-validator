CREATE PROCEDURE dbo.sample_codegen_update
(
	@id int =0,
	@username varchar(10) = null,
	@age int =0

)

	AS

    set nocount on
    set transaction isolation level read uncommitted

	UPDATE dbo.SAMPLE_TEST_TBL
	SET NAME = @username
	,	AGE = @age
	WHERE ID=@id

	IF @@ERROR = 0
	BEGIN

		SELECT  TOP 1 ID AS ID
		,	NAME AS USERNAME
		,	AGE AS AGE
		FROM DBO.SAMPLE_TEST_TBL STT with(nolock)
		WHERE STT.ID=@ID
	END
